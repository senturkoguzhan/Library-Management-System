/**
 * Table class which extends Inventory
 */
public class Table extends Inventory implements Comparable {

    /**
     * Holds time for a break
     */
    private int breakCounter;

    /**
     * Default Constructor
     */
    public Table(){
        super();
        breakCounter = 0;
    }

    /**
     * Instantiates a new Table.
     *
     * @param id     the id
     * @param status the status
     * @param time   the time
     */
    protected Table(String id, String status, Integer time) {
        super(id, status, time);
        breakCounter = 0;
    }

    /**
     * Changes status of the table
     */
    @Override
    public void changeStatus(String newStatus){
        if(isAvailable())
            setStatus(newStatus);
        else
            System.out.println(User.ANSI_RED + "Table has already occupied" + User.ANSI_RESET);
    }

    /**
     * Updates time of a the table for 60 minutes (1 hour)
     */
    @Override
    public void updateTime() {
        setTime(getTime()-1);
    }


    @Override
    /**
     * Method to compare table times
     * Helper for priority queue data structure
     */
    public int compareTo(Object o) {

        if(this.getTime() < ((Table)o).getTime())
            return -1;

        else if(this.getTime().equals(((Table) o).getTime()))
            return 0;

        else
            return 1;
    }
}
