package info.movietrash.cinemabase.converter.impl;

import info.movietrash.cinemabase.converter.GenreConverter;
import info.movietrash.cinemabase.dto.GenreDto;
import info.movietrash.cinemabase.model.Genre;

import java.util.ArrayList;
import java.util.List;

public class GenreConverterImpl implements GenreConverter {
    @Override
    public List<Genre> toModel(List<GenreDto> genreDtoList) {
        if (genreDtoList != null) {
            List<Genre> genreList = new ArrayList<>();
            for (int i = 0; i < genreDtoList.size(); i++) {
                GenreDto genreDto = genreDtoList.get(i);
                Genre genre = new Genre();
                genre.setExternalId(genreDto.getExternalId());
                genre.setName(genreDto.getName());
                genreList.add(genre);
            }
            return genreList;
        }
        return null;
    }

    @Override
    public List<GenreDto> toDto(List<Genre> genreList) {
        if (genreList != null) {
            List<GenreDto> genreDtoList = new ArrayList<>();
            for (int i = 0; i < genreList.size(); i++) {
                Genre genre = genreList.get(i);
                GenreDto genreDto = new GenreDto();
                genreDto.setExternalId(genre.getExternalId());
                genreDto.setName(genre.getName());
                genreDtoList.add(genreDto);
            }
            return genreDtoList;
        }
        return null;
    }
}
