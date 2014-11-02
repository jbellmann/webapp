package de.sturmbergen.service.status;

import java.util.List;

import de.sturmbergen.domain.DungeonMaster;
import de.sturmbergen.domain.OnlineStatus;
import de.sturmbergen.domain.Player;

public class ServerStatus {

    private OnlineStatus status;

    private List<Player> players;
    private List<DungeonMaster> sls;

    public List<Player> getPlayers() {
	return players;
    }

    public void setPlayers(List<Player> players) {
	this.players = players;
    }

    public List<DungeonMaster> getSls() {
	return sls;
    }

    public void setSls(List<DungeonMaster> sls) {
	this.sls = sls;
    }

    public OnlineStatus getStatus() {
	return status;
    }

    public void setStatus(OnlineStatus status) {
	this.status = status;
    }

}
