package ipl.dashbord.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private  long id;
   private  long totalMatches;
   private  long totalWins;
   private String teamName;

    public Team( String teamName,long totalMatches) {
        this.teamName = teamName;
        this.totalMatches = totalMatches;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTotalMatches() {
        return totalMatches;
    }

    public void setTotalMatches(long totalMatches) {
        this.totalMatches = totalMatches;
    }

    public long getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(long totalWins) {
        this.totalWins = totalWins;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", totalMatches=" + totalMatches +
                ", totalWins=" + totalWins +
                ", teamName='" + teamName + '\'' +
                '}';
    }
}