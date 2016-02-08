package abstract_and_interface;

public class IdGenerator {
	public static String generate(Product product, String id){		
		String newId = "";
			
		if (product instanceof Movie) {
				newId = "MOV_" + id;
			} 
		if (product instanceof Game) {
				newId = "GAM_" + id;
			} 
		if (product instanceof Book) {
				newId = "BOO_" + id;
			}
		return newId;
		}
}
