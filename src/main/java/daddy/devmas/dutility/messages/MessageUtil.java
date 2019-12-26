package daddy.devmas.dutility.messages;

import daddy.devmas.dutility.DUtility;

public class MessageUtil {

    private DUtility dUtility;
    public MessageUtil(DUtility dUtility) {
        this.dUtility = dUtility;
    }

    public String centerChat(String msg) {
        return MessageCentre.chatCentre(msg);
    }

    public String centreMOTD(String msg) {
        return MessageCentre.centerMOTD(msg);
    }

    public String timeRemainingLong(long timeInSeconds) {
        int years = (int) timeInSeconds / 31556952;
        int months = (int) (timeInSeconds % 31556952) / 2628000;
        int weeks = (int) ((timeInSeconds % 31556952) % 2628000) / 604800;
        int days = (int) (((timeInSeconds % 31556952) % 2628000) % 604800) / 86400;
        int hours = (int) ((((timeInSeconds % 31556952) % 2628000) % 604800) % 86400)  / 3600;
        int minutes = (int) (((((timeInSeconds % 31556952) % 2628000) % 604800) % 86400) % 3600) / 60;
        int seconds = (int) ((((((timeInSeconds % 31556952) % 2628000) % 604800) % 86400) % 3600) % 60);

        return (years > 0 ? years + (years > 1 ? " years, " : " year, ") : "") +
                (months > 0 ? months + (months > 1 ? " months, " : " month, ") : "") +
                (weeks > 0 ? weeks + (weeks > 1 ? " weeks, " : " week, ") : "") +
                (days > 0 ? days + (days > 1 ? " days, " : " day, ") : "") +
                (hours > 0 ? hours + (hours > 1 ? " hours, " : " hour, ") : "") +
                (minutes > 0 ? minutes + (minutes > 1 ? " minutes, " : " minute, ") : "") +
                (seconds > 1 ? seconds + " seconds." : seconds + " second.");
    }

    public String timeRemainingShort(long timeInSeconds) {
        int years = (int) timeInSeconds / 31556952;
        int months = (int) (timeInSeconds % 31556952) / 2628000;
        int weeks = (int) ((timeInSeconds % 31556952) % 2628000) / 604800;
        int days = (int) (((timeInSeconds % 31556952) % 2628000) % 604800) / 86400;
        int hours = (int) ((((timeInSeconds % 31556952) % 2628000) % 604800) % 86400)  / 3600;
        int minutes = (int) (((((timeInSeconds % 31556952) % 2628000) % 604800) % 86400) % 3600) / 60;
        int seconds = (int) ((((((timeInSeconds % 31556952) % 2628000) % 604800) % 86400) % 3600) % 60);

        return (years > 0 ? years + (years > 1 ? "yrs, " : "yr, ") : "") +
                (months > 0 ? months + (months > 1 ? "m, " : "m, ") : "") +
                (weeks > 0 ? weeks + (weeks > 1 ? "w, " : "w, ") : "") +
                (days > 0 ? days + (days > 1 ? "d, " : "d, ") : "") +
                (hours > 0 ? hours + (hours > 1 ? "h, " : "h, ") : "") +
                (minutes > 0 ? minutes + (minutes > 1 ? "m, " : "m, ") : "") +
                (seconds > 1 ? seconds + "s." : seconds + "s.");
    }
}
