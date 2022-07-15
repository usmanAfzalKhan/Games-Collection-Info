package uKhan.Collection;

/** 
 * No description required
 * @author Usman
 */
public class GameRecord {

    private String gameName;
    private Integer minPlayers;
    private Integer maxPlayers;
    private Double price;
    private String description;

    public GameRecord() {
    }

    public GameRecord(String gameName, Integer minPlayers, Integer maxPlayers, 
            Double price, String description) {
        setGameName(gameName);
        setMinPlayers(minPlayers);
        setMaxPlayers(maxPlayers);
        setPrice(price);
        setDescription(description);
    }

    public String getGameName() {
        return gameName;
    }

    public Integer getMinPlayers() {
        return minPlayers;
    }

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setGameName(String gameName) throws IllegalArgumentException {
        if (validateString(gameName)) {
            this.gameName = gameName;
        } else {
            throw new IllegalArgumentException("Game name cant be empty null "
                    + "or blank.");
        }
    }

    public void setMinPlayers(Integer minPlayers) throws IllegalArgumentException 
    {
        if (validateMinInteger(minPlayers)) {
            this.minPlayers = minPlayers;
        } else {
            throw new IllegalArgumentException("Players are only inclusive from 1 "
                    + "and 42");
        }
    }

    public void setMaxPlayers(Integer maxPlayers) throws IllegalArgumentException {
        if (validateMaxInteger(maxPlayers)) {
            this.maxPlayers = maxPlayers;
        } else {
            throw new IllegalArgumentException("Players are only inclusive "
                    + "from minimum players and 10");
        }
    }

    public void setPrice(Double price) throws IllegalArgumentException {
        if (validatePrice(price)) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Price cannot be less than 0");
        }
    }

    public void setDescription(String description) throws IllegalArgumentException 
    {
        if (validateString(description)) {
            this.description = description;
        } else {
            throw new IllegalArgumentException("Description cannot be empty");
        }
    }

    private boolean validateString(String s) {
        if (s == null || s.isEmpty() || s.isBlank()) {
            return false;
        }
        return true;
    }

    private boolean validateMaxInteger(Integer p) {
        if (p >= 42 || p <= 0) {
            return false;
        }
        return true;
    }

    private boolean validateMinInteger(Integer p) {
        if (p >= 10 || p <= 0) {
            return false;
        }
        return true;
    }

    private boolean validatePrice(Double money) {
        if (money < 0) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return gameName + "is a video game  for " + minPlayers + " to "
                + maxPlayers + ", " + description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof GameRecord)) {
            return false;
        }

        GameRecord otherGames = (GameRecord) o;
        return (gameName.equalsIgnoreCase(otherGames.gameName)
                && description.equalsIgnoreCase(otherGames.description)
                && minPlayers.equals(otherGames.minPlayers)
                && maxPlayers.equals(otherGames.maxPlayers));
    }

}
