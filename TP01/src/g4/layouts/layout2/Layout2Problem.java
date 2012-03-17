package g4.layouts.layout2;

import g4.MahjongGPSState;
import g4.MahjongProblem;
import g4.heuristics.Heuristic;
import gps.api.GPSState;
import aga.mahjong.core.Board;

public class Layout2Problem extends MahjongProblem {

	public Layout2Problem(Heuristic heuristic1){
		this.heuristic = heuristic1;
	}
	
  @Override
  public GPSState getInitState() {
    MahjongGPSState gpsState = new MahjongGPSState();
    Board  board = new Board(new Layout2());
    Layout2Arrange arrange = new Layout2Arrange();
    arrange.arrange(board);
    gpsState.setBoard(board);
    
    assert(board.getPayersCount() > 0);
    return gpsState;
  }

  @Override
  public GPSState getGoalState() {
    MahjongGPSState gpsState = new MahjongGPSState();
    Board  board = new Board(new Layout2());
    gpsState.setBoard(board);

    assert(board.getPayersCount() == 0);
    return gpsState;
  }

//  @Override
//  public List<GPSRule> getRules(GPSState state) {
//    List<GPSRule> rules = new ArrayList<GPSRule>();
//
//    MahjongGPSState gpsState = (MahjongGPSState) state;
//    int count = gpsState.getBoard().getPayersCount();
//
//    for (int i = 0 ; i < count ; i++ ) {
//      rules.add(new MahjongGPSRule(i));
//    }
//
//    System.out.println("rules count: " + rules.size());
//
//    return rules;
//  }
//
//  @Override
//  public Integer getHValue(GPSState state) {
//    return null;
//  }

}
