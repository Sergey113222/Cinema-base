package info.movietrash.cinemabase.converter;

import info.movietrash.cinemabase.dto.GenreDto;
import info.movietrash.cinemabase.model.Genre;

import java.util.List;

public interface GenreConverter {
    List<Genre> toModel(List<GenreDto> genreDtoList);

    List<GenreDto> toDto(List<Genre> genreList);
}
