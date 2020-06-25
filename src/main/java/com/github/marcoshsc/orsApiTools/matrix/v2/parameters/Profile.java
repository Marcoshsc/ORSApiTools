package com.github.marcoshsc.orsApiTools.matrix.v2.parameters;

import com.fasterxml.jackson.annotation.JsonValue;
import com.github.marcoshsc.orsApiTools.directions.enums.EnumProfile;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Profile {

    private final EnumProfile profile;

}
