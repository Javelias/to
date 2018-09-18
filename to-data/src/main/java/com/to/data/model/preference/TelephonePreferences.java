package com.to.data.model.preference;

import com.to.data.model.data.IScheduleConfiguration;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class TelephonePreferences {

    /**
     * Duid minstens vier mogelijkheden aan, op minstens twee verschillende dagen.
     * ☒☐ Eén vakje is een gewone mogelijkheid.
     * ☒☒   Door twee vakjes aan te duiden, geef je je voorkeuren aan.
     * We waarderen het als je méér mogelijkheden kan aanduiden. Dit helpt om de bezetting goed te verdelen.
     */
    public List<VolunteerPreference> getWeekSchedule(IScheduleConfiguration schedule);

    /**
     * Duid minstens drie weekendmogelijkheden aan, waarvan één op zaterdag tussen 13 uur en 01 uur of op
     * zondag tussen 13 uur en 22 uur. Het helpt als je meer mogelijkheden kan aanduiden. Duid ook mogelijkheden op
     * feestdagen aan. Deze tellen als weekenddiensten. We verdelen feestdagen over de groep.
     */
    private IScheduleConfiguration weekendSchedule;

    /**
     * Geef minstens twee mogelijkheden voor de voornacht- (23-02) diensten én twee mogelijkheden voor de nanacht-
     * (02-07) diensten op. Ook hier helpt het als je nog meer mogelijkheden kan aanduiden.
     */
    private IScheduleConfiguration nightSchedule;

    /**
     * We houden rekening met 6 weken afwezigheid per jaar. Die kan je hier aanduiden.
     */
    private Map<LocalDateTime,LocalDateTime> absences;

    /**
     * Ben je bereid om in deze beurtrol, binnen de door jouw opgegeven mogelijkheden, iets extra te doen om de
     * beurtrol zo goed mogelijk ingevuld te krijgen?
     * ☐	1, 2, 3, …. dienst(en) extra. Omcirkel of vul aan hoeveel extra diensten je kan doen.
     * ☐	1, 2, 3, …. weekenddienst(en) extra. Omcirkel of vul aan hoeveel extra weekenddiensten je kan doen.
     *
     * Ben je bereid, in plaats van een gewone dienst een extra voor- of nanacht te doen?
     * ☐   Eén extra voornacht of …….  voornachten.                  ☐   Eén extra nanacht of …….  nanachten.
     *
     * Als je normaal gezien geen late avonddiensten aanduidt, ben je dan bereid om uitzonderlijk
     * ☐ ….. keer de dienst van 20-23 te doen? Op ma, di, wo, do, vr, za of zo? Omcirkel de dagen waarop het kan.
     * ☐ ….. keer de dienst van 22-01 te doen? Op ma, di, wo, do, vr, za of zo? Omcirkel de dagen waarop het kan.
     */
    private int extraWeekShifts;
    private int extraWeekendShifts;
    private int extraBeforeNightShifts;
    private int extraAfterNightShifts;
    private Map<Integer,List<DayOfWeek>> extra2023EveningShifts;
    private Map<Integer,List<DayOfWeek>> extra2201EveningShifts;



}
