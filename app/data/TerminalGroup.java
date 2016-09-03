package data;

import java.util.ArrayList;

/**
 * Created by Joe on 03/09/2016.
 */
public class TerminalGroup {

    public ArrayList<Terminal> terminals = new ArrayList<>();
    public double groupTotalFlow = 0.0;
    public String groupTimestamp;
    public String terminalGroupName;

    public TerminalGroup(String name) {
        terminalGroupName = name;
    }

    public TerminalGroup addTerminal(Terminal term) {
        terminals.add(term);
        groupTimestamp = terminals.get(0).timestamp;
        groupTotalFlow = groupTotalFlow + term.flowValue;
        return this;
    }
}