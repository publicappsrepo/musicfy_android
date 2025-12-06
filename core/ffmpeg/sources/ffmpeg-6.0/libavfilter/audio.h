

#ifndef AVFILTER_AUDIO_H
#define AVFILTER_AUDIO_H

#include "avfilter.h"
#include "internal.h"

/** default handler for get_audio_buffer() for audio inputs */
AVFrame *ff_default_get_audio_buffer(AVFilterLink *link, int nb_samples);

/** get_audio_buffer() handler for filters which simply pass audio along */
AVFrame *ff_null_get_audio_buffer(AVFilterLink *link, int nb_samples);

/**
 * Request an audio samples buffer with a specific set of permissions.
 *
 * @param link           the output link to the filter from which the buffer will
 *                       be requested
 * @param nb_samples     the number of samples per channel
 * @return               on success an AVFrame owned by the caller, NULL on error
 */
AVFrame *ff_get_audio_buffer(AVFilterLink *link, int nb_samples);

#endif /* AVFILTER_AUDIO_H */
