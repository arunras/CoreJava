package core.fundamentals.models;

import java.util.Map;

public interface MaterialCatalogInterface {
  public void addMaterial(Material newMaterial);
  public int getNumberOfMaterials();
  public Material findMaterial(String title) throws MaterialNotFoundException;
  public Map<String, Material> getMaterialMap();
}
