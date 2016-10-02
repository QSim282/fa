
import java.util.*;

public class NameVault 
{
	private int position = 0;	
	private Map<Integer, Person> hmap = new HashMap<Integer, Person>();

	public NameVault(){
		
	}
	
	public void incPosition(){
		position++;
	}
	public Person locatePerson(String name2){
		for(int i=0;i<hmap.size();i++){
			if(hmap.get(i).getName().equals(name2)){
				return hmap.get(i);
			}
		}
		return null;
	}
	public ArrayList<Person> printHash(){
		ArrayList<Person> temp = new ArrayList<Person>();
		for(int i=0;i<hmap.size();i++){
			if(hmap.get(i).getName() != null){
			temp.add(hmap.get(i));
			}
		}
		return temp;
	}
	public void removeName(String name){		
		for(int i=0;i<hmap.size();i++){
			if(hmap.get(i).getName().equals(name)){
				hmap.remove(i);
			}
		}
	}
	public void inputName(String name, int employ, int vet )
	{		
		Person temp = new Person(name,0,employ,vet);
		hmap.put(position, temp);
		incPosition();
	}
}
