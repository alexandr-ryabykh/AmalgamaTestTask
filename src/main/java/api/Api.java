package api;

import api.varieties.Variety;

public interface Api {
    public Api variety(String description);

    public Float closestTo(Float number);

    public Variety intersection();

    public void clear();
}
