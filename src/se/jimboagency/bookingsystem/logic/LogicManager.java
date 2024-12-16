package se.jimboagency.bookingsystem.logic;

import java.util.*;


public class LogicManager {

	//inlogg
	private String text;
	private String[] args;
	
    public LogicManager(String[] args) {
        this.setArgs(args);
    }

	public String getValue() {
        return text;
    }

    public void setValue(String value) {
        if (value == null || value.isEmpty()) throw new IllegalArgumentException("Text cannot be null or empty");
        this.text = value;
    }

    @Override
    public int hashCode() {
        return text.hashCode();
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LogicManager word = (LogicManager) obj;
        return text.equals(word.text);
    }
    
    private Map<LogicManager, Set<LogicManager>> inlog = new HashMap<>();

    public void add(LogicManager t, LogicManager m) {
    	inlog.computeIfAbsent(t, k -> new HashSet<>()).add(m);
    }

    public void add(String t, String m) {
        add(new LogicManager(t), new LogicManager(m));
    }

    public Set<LogicManager> terms() {
        return inlog.keySet();
    }

    public Set<LogicManager> lookup(LogicManager t) {
        return inlog.getOrDefault(t, Collections.emptySet());
    }
    
    public LogicManager inverse() {
    	LogicManager inverted = new LogicManager();
        for (Map.Entry<LogicManager, Set<LogicManager>> entry : inlog.entrySet()) {
        	LogicManager key = entry.getKey();
            for (LogicManager value : entry.getValue()) {
                inverted.add(value, key); 
            }
        }
        
        System.out.println("Inverterad ordbok:");
        for (LogicManager key : inverted.terms()) {
            System.out.println(key + " -> " + inverted.lookup(key));
        }
        return inverted;
    }
    
    
    //authenticate
    private Scanner input = new Scanner(System.in);
    private Dictionary inlogginfo;


    public void runQuiz() {
        Set<LogicManager> terms = new HashSet<>(inlogginfo.terms());
        
        System.out.println("Användning av ordbok: " + inlogginfo);
        
        while (!terms.isEmpty()) {
            Iterator<LogicManager> iterator = terms.iterator();
            List<LogicManager> missed = new ArrayList<>();
        
            while (iterator.hasNext()) {
            	LogicManager term = iterator.next();
                System.out.print(term + " = ");
                if (!input.hasNextLine()) {
                    System.out.println("Ingen rad hittades. Avslutar quiz.");
                    return;
                }
                String answer = input.nextLine().trim();
                
                Set<LogicManager> meanings = inlogginfo.lookup(term);
    
                System.out.println("Fråga: " + term + " -> Svar: " + answer);
    
                if (meanings.stream().anyMatch(m -> m.toString().equalsIgnoreCase(answer))) {
                    iterator.remove();
                    System.out.println("Välkommen");
                } else {
                    missed.add(term);
                    System.out.println("Womp Womp");
                }
            }
        }
    }

	public String[] getArgs() {
		return args;
	}

	public void setArgs(String[] args) {
		this.args = args;
	} 
}













