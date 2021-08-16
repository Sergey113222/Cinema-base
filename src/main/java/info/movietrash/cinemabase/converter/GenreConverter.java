package info.movietrash.cinemabase.converter;

import info.movietrash.cinemabase.dto.ExternalGenreDto;
import info.movietrash.cinemabase.model.Genre;

import java.util.List;

public interface GenreConverter {
    List<Genre> toModel(List<ExternalGenreDto> externalGenreDtoList);

    List<ExternalGenreDto> toDto(List<Genre> genreList);
}
