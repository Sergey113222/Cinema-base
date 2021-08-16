package info.movietrash.cinemabase.converter;

import info.movietrash.cinemabase.dto.ProfileDto;
import info.movietrash.cinemabase.model.Profile;

public interface ProfileConverter {
    Profile toModel(ProfileDto profileDto);

    ProfileDto toDto(Profile profile);
}
