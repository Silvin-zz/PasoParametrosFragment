package pikino.pasoparametrosfragment;

/**
 * Created by silviobravocado on 07/09/15.
 */
public class PokemonEntity {
    private int    id;
    private String name;
    private String description;
    private String attack;
    private String defense;
    private int    imageSource;


    public PokemonEntity(int id, String name, String description, String attack, String defense, int imageSource) {
        this.id             = id;
        this.name           = name;
        this.description    = description;
        this.attack         = attack;
        this.defense        = defense;
        this.imageSource    = imageSource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public String getDefense() {
        return defense;
    }

    public void setDefense(String defense) {
        this.defense = defense;
    }

    public int getImage() {
        return imageSource;
    }

    public void setImage(int imageSource) {
        this.imageSource = imageSource;
    }

    public PokemonEntity() {
    }
}
