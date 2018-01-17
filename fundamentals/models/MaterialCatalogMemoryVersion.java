package core.fundamentals.models;

import java.util.TreeMap;

public class MaterialCatalogMemoryVersion implements MaterialCatalogInterface{
  private TreeMap<String, Material> materialMap;

  public MaterialCatalogMemoryVersion() {
    materialMap = new TreeMap<>();
  }
  
  @Override
  public void addMaterial(Material newMaterial) {
    materialMap.put(newMaterial.getID(), newMaterial);
  }

  @Override
  public TreeMap<String, Material> getMaterialMap() {
    return this.materialMap;
  }

  @Override
  public Material findMaterial(String title) throws MaterialNotFoundException{
  		title = title.trim();
  		for (Material nextMaterial : materialMap.values()) {
  			if (nextMaterial.getTitle().equalsIgnoreCase(title)) {
  				return nextMaterial;
  			}
  		}
  		
    throw new MaterialNotFoundException();
  }
  
  @Override
  public int getNumberOfMaterials() {
  		return materialMap.size();
  }
}
