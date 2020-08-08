package info.kfgodel.processink.api.original

/**
 * This type represents the API that Processing offers to its users from its PApplet class.<br>
 * <br>
 * This type declares all the available methods in the original Processing API adding documentation to each method
 * and explaining some behavior not explicit in the original documentation<br>
 * <br>
 * Because the original API has too many methods in the same object this interface has been divided into parts
 * in order to group related methods and facilitate their understanding. However that doesn't change the fact
 * that the PApplet objet still has all at the same level.
 *
 * Date: 8/8/20 - 17:39
 */
interface ProcessingOriginalApi :
  OriginalEnvironmentApi,
  OriginalTypographyApi,
  OriginalShapeApi