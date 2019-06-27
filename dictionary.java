import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; 

/*This code was copied from user drewmore on StackOverflow,
 * with some slight alterations to the base. If you would like to find the original code,
 * you can find it at 
 * https://codereview.stackexchange.com/questions/48908/java-implementation-of-spell-checking-algorithm
 */
		

public class dictionary {
	private int M = 2029;
    final private Bucket[] array;
    public dictionary() {
    	
        array = new Bucket[M];
        for (int i = 0; i < M; i++) {
            array[i] = new Bucket();
        }
    }

    private int hash(String key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    //call hash() to decide which bucket to put it in, do it.
    public void add(String key) {
        array[hash(key)].put(key);
    }

    //call hash() to find what bucket it's in, get it from that bucket. 
    public boolean contains(String input) {
        input = input.toLowerCase();
        return array[hash(input)].get(input);
    }

    public void build(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                add(line);
            }
            reader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }
    //this method is used in my unit tests
    @SuppressWarnings("rawtypes")
	public String[] getRandomEntries(int num){
        String[] toRet = new String[num];
        for (int i = 0; i < num; i++){
            //pick a random bucket, go out a random number 
            Node n = array[(int)Math.random()*M].first;
            int rand = (int)Math.random()*(int)Math.sqrt(num);

            for(int j = 0; j<rand && n.getNextNode() != null; j++) n = n.getNextNode();
            toRet[i]=(String) n.data;


        }
        return toRet;
    }
}
