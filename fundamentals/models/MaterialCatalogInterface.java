package core.fundamentals.models;

import java.util.Map;
import java.util.List;

public interface MaterialCatalogInterface {
  public void addMaterial(Material newMaterial);
  public int getNumberOfMaterials();
  public Material findMaterial(String title) throws MaterialNotFoundException;
  public Map<String, Material> getMaterialMap();
  public List<Material> findItemsSoundingLike(String title);
}
