package ipl.dashbord.data;

import ipl.dashbord.model.Match;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import java.time.LocalDate;

//Processes a single record from csv file and insert into database
public class MatchDataProcessor implements ItemProcessor<MatchInput, Match>{
    private static Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

    @Override
    public Match process(MatchInput matchInput) throws Exception {

        Match match = new Match();

        match.setId(Long.parseLong(matchInput.getId()));
        match.setCity(matchInput.getCity());
        match.setDate(LocalDate.parse(matchInput.getCity()));
        match.setPlayerOfMatch(matchInput.getPlayer_of_match());
        match.setVenue(matchInput.getVenue());

        //set Team 1 and 2 depending upon innings order
        String firstInningsTeam,secondInningsTeam;
        if ("bat".equals(matchInput.getToss_decision())){
            firstInningsTeam = match.getTossWinner();
            secondInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam1())
            ? matchInput.getTeam1() : match.getTeam2();
        }else{
            secondInningsTeam = match.getTeam2();
            firstInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam1())
                    ? matchInput.getTeam2() : matchInput.getTeam1();
        }

        match.setTeam1(firstInningsTeam);
        match.setTeam2(secondInningsTeam);
        match.setTossWinner(matchInput.getToss_winner());
        match.setTossDecision(matchInput.getToss_decision());
        match.setWinner(matchInput.getWinner());
        match.setResult(matchInput.getResult());
        match.setResultMargin(matchInput.getResult_margin());
        match.setUmpire1(matchInput.getUmpire1());
        match.setUmpire2(matchInput.getUmpire2());

        return match;
    }
}
