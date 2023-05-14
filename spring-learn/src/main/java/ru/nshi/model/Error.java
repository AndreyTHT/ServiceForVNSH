package ru.nshi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
//@Getter
//@Setter
//@EqualsAndHashCode
public class Error {
    @JsonProperty("message")
    private String errorMessage;

    //region Test
    public static Error getInstance() {
        return null;
    }

    public boolean isEmpty() {
        return errorMessage.isEmpty();
    }
//endregion
}
