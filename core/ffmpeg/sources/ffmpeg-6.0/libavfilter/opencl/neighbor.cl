__kernel void erosion_global(__write_only image2d_t dst,
                             __read_only  image2d_t src,
                             float threshold,
                             __constant int *coord)
{
    const sampler_t sampler = (CLK_NORMALIZED_COORDS_FALSE |
                               CLK_ADDRESS_CLAMP_TO_EDGE   |
                               CLK_FILTER_NEAREST);

    int2 loc = (int2)(get_global_id(0), get_global_id(1));

    float4 px = read_imagef(src, sampler, loc);
    float limit = px.x - threshold;
    if (limit < 0) {
        limit = 0;
    }

    for (int i = -1; i <= 1; i++) {
        for (int j = -1; j <= 1; j++) {
            if (coord[(j + 1) * 3 + (i + 1)] == 1) {
                float4 cur = read_imagef(src, sampler, loc + (int2)(i, j));
                if (cur.x < px.x) {
                    px = cur;
                }
            }
        }
    }
    if (limit > px.x) {
        px = (float4)(limit);
    }
    write_imagef(dst, loc, px);
}


__kernel void dilation_global(__write_only image2d_t dst,
                              __read_only  image2d_t src,
                              float threshold,
                              __constant int *coord)
{
    const sampler_t sampler = (CLK_NORMALIZED_COORDS_FALSE |
                               CLK_ADDRESS_CLAMP_TO_EDGE   |
                               CLK_FILTER_NEAREST);

    int2 loc = (int2)(get_global_id(0), get_global_id(1));

    float4 px = read_imagef(src, sampler, loc);
    float limit = px.x + threshold;
    if (limit > 1) {
        limit = 1;
    }

    for (int i = -1; i <= 1; i++) {
        for (int j = -1; j <= 1; j++) {
            if (coord[(j + 1) * 3 + (i + 1)] == 1) {
                float4 cur = read_imagef(src, sampler, loc + (int2)(i, j));
                if (cur.x > px.x) {
                    px = cur;
                }
            }
        }
    }
    if (limit < px.x) {
        px = (float4)(limit);
    }
    write_imagef(dst, loc, px);
}
