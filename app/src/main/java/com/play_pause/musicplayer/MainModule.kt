/*
 * Copyright (c) 2024 Christians Martínez Alvarado
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.play_pause.musicplayer

import androidx.preference.PreferenceManager
import androidx.room.Room
import com.play_pause.musicplayer.activities.tageditor.TagEditorViewModel
import com.play_pause.musicplayer.androidauto.AutoMusicProvider
import com.play_pause.musicplayer.audio.SoundSettings
import com.play_pause.musicplayer.database.BoomingDatabase
import com.play_pause.musicplayer.fragments.LibraryViewModel
import com.play_pause.musicplayer.fragments.albums.AlbumDetailViewModel
import com.play_pause.musicplayer.fragments.artists.ArtistDetailViewModel
import com.play_pause.musicplayer.fragments.equalizer.EqualizerViewModel
import com.play_pause.musicplayer.fragments.genres.GenreDetailViewModel
import com.play_pause.musicplayer.fragments.info.InfoViewModel
import com.play_pause.musicplayer.fragments.lyrics.LyricsViewModel
import com.play_pause.musicplayer.fragments.playlists.PlaylistDetailViewModel
import com.play_pause.musicplayer.fragments.search.SearchViewModel
import com.play_pause.musicplayer.fragments.sound.SoundSettingsViewModel
import com.play_pause.musicplayer.fragments.years.YearDetailViewModel
import com.play_pause.musicplayer.http.deezer.DeezerService
import com.play_pause.musicplayer.http.github.GitHubService
import com.play_pause.musicplayer.http.jsonHttpClient
import com.play_pause.musicplayer.http.lastfm.LastFmService
import com.play_pause.musicplayer.http.lyrics.LyricsService
import com.play_pause.musicplayer.http.provideDefaultCache
import com.play_pause.musicplayer.http.provideOkHttp
import com.play_pause.musicplayer.model.Genre
import com.play_pause.musicplayer.providers.MediaStoreWriter
import com.play_pause.musicplayer.repository.*
import com.play_pause.musicplayer.service.equalizer.EqualizerManager
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
    factory {
        jsonHttpClient(get())
    }
    factory {
        provideDefaultCache()
    }
    factory {
        provideOkHttp(get(), get())
    }
    single {
        GitHubService(androidContext(), get())
    }
    single {
        DeezerService(get())
    }
    single {
        LastFmService(get())
    }
    single {
        LyricsService(androidContext(), get())
    }
}

private val autoModule = module {
    single {
        AutoMusicProvider(androidContext(), get())
    }
}

private val mainModule = module {
    single {
        androidContext().contentResolver
    }
    single {
        EqualizerManager(androidContext())
    }
    single {
        SoundSettings(androidContext())
    }
    single {
        MediaStoreWriter(androidContext(), get())
    }
    single {
        PreferenceManager.getDefaultSharedPreferences(androidContext())
    }
}

private val roomModule = module {
    single {
        Room.databaseBuilder(androidContext(), BoomingDatabase::class.java, "music_database.db")
            .build()
    }

    factory {
        get<BoomingDatabase>().playlistDao()
    }

    factory {
        get<BoomingDatabase>().playCountDao()
    }

    factory {
        get<BoomingDatabase>().historyDao()
    }

    factory {
        get<BoomingDatabase>().inclExclDao()
    }

    factory {
        get<BoomingDatabase>().lyricsDao()
    }
}

private val dataModule = module {
    single {
        RealRepository(
            androidContext(),
            get(),
            get(),
            get(),
            get(),
            get(),
            get(),
            get(),
            get(),
            get(),
            get()
        )
    } bind Repository::class

    single {
        RealSongRepository(get())
    } bind SongRepository::class

    single {
        RealAlbumRepository(get())
    } bind AlbumRepository::class

    single {
        RealArtistRepository(get(), get())
    } bind ArtistRepository::class

    single {
        RealPlaylistRepository(androidContext(), get(), get())
    } bind PlaylistRepository::class

    single {
        RealGenreRepository(get(), get())
    } bind GenreRepository::class

    single {
        RealSearchRepository(get(), get(), get(), get(), get(), get())
    } bind SearchRepository::class

    single {
        RealSmartRepository(androidContext(), get(), get(), get(), get(), get())
    } bind SmartRepository::class

    single {
        RealSpecialRepository(get())
    } bind SpecialRepository::class
}

private val viewModule = module {
    viewModel {
        LibraryViewModel(get(), get())
    }

    viewModel {
        EqualizerViewModel(get(), get(), get())
    }

    viewModel { (albumId: Long) ->
        AlbumDetailViewModel(get(), albumId)
    }

    viewModel { (artistId: Long, artistName: String?) ->
        ArtistDetailViewModel(get(), artistId, artistName)
    }

    viewModel { (playlistId: Long) ->
        PlaylistDetailViewModel(get(), playlistId)
    }

    viewModel { (genre: Genre) ->
        GenreDetailViewModel(get(), genre)
    }

    viewModel { (year: Int) ->
        YearDetailViewModel(get(), year)
    }

    viewModel {
        SearchViewModel(get())
    }

    viewModel { (id: Long, name: String?) ->
        TagEditorViewModel(get(), id, name)
    }

    viewModel {
        LyricsViewModel(get(), get())
    }

    viewModel {
        InfoViewModel(get())
    }

    viewModel {
        SoundSettingsViewModel(get())
    }
}

val appModules = listOf(networkModule, autoModule, mainModule, roomModule, dataModule, viewModule)