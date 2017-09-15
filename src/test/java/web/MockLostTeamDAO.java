package web;

import java.util.ArrayList;
import java.util.List;

import data.State;
import data.StateDAO;

public class MockLostTeamDAO implements StateDAO {

	List<State> states;
	public MockLostTeamDAO() {
		states = new ArrayList<>();
		loadStates();
	}

	public void loadStates(){
		states.clear();
		states.add(new State("MI", "Michigan", "Lansing", "1.0", "2.0", "1_000_000"));
		states.add(new State("CO", "Colorado", "Denver", "3", "4", "2_000_000"));
	}

	@Override
	public State getStateByName(String name) {
		State s = null;
		for (State state : states) {
			if (state.getName().equalsIgnoreCase(name)) {
				s = state;
				break;
			}
		}
		return s;
	}
	@Override
	public State getStateByAbbreviation(String abbrev) {
		State s = null;
		for (State state : states) {
			if (state.getAbbreviation().equalsIgnoreCase(abbrev)) {
				s = state;
				break;
			}
		}
		return s;
	}
	@Override
	public void addState(State state) {
		states.add(state);
	}

	@Override
	public List<State> getAllStates() {
		// TODO Auto-generated method stub
		return null;
	}

}
