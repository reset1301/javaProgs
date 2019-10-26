package rrrr;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GeoJson {
    @JsonProperty(value = "type")
    private String type;
    @JsonProperty(value = "coordinates")
    private List<Double[]> coordinates;
}