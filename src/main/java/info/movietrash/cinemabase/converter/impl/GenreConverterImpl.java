package info.movietrash.cinemabase.converter.impl;

import info.movietrash.cinemabase.converter.GenreConverter;
import info.movietrash.cinemabase.dto.ExternalGenreDto;
import info.movietrash.cinemabase.model.Genre;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GenreConverterImpl implements GenreConverter {
    @Override
    public List<Genre> toModel(List<ExternalGenreDto> externalGenreDtoList) {

        List<Genre> genreList = new ArrayList<>();
        for (int i = 0; i < externalGenreDtoList.size(); i++) {
            ExternalGenreDto externalGenreDto = externalGenreDtoList.get(i);
            Genre genre = new Genre();
            genre.setExternalId(externalGenreDto.getExternalId());
            genre.setName(externalGenreDto.getName());
            genreList.add(genre);
        }
        return genreList;
    }

    @Override
    public List<ExternalGenreDto> toDto(List<Genre> genreList) {

        List<ExternalGenreDto> externalGenreDtoList = new ArrayList<>();
        for (int i = 0; i < genreList.size(); i++) {
            Genre genre = genreList.get(i);
            ExternalGenreDto externalGenreDto = new ExternalGenreDto();
            externalGenreDto.setExternalId(genre.getExternalId());
            externalGenreDto.setName(genre.getName());
            externalGenreDtoList.add(externalGenreDto);
        }
        return externalGenreDtoList;
    }
}
