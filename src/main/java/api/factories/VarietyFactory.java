package api.factories;

import api.varieties.Variety;
import api.varieties.LeafVariety;
import api.varieties.CompositeVariety;

import api.patterns.VarietyPattern;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class VarietyFactory {
    public static Variety create(String description) {
        ArrayList<String> varietiesSources = new VarietyPattern().match(description);

        ArrayList<Variety> varieties = varietiesSources.stream()
                .map(varietySource -> BoundFactory.create(varietySource))
                .map(bounds -> new LeafVariety(bounds[0], bounds[1]))
                .collect(Collectors.toCollection(ArrayList::new));

        return varieties.size() > 1 ? new CompositeVariety(varieties) : varieties.get(0);
    }
}
