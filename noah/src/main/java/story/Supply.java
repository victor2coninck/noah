package story;

class Supply
{
    private int meat_supply;
    private int grass_supply;

    public Supply(int meat_qte, int grass_qte)
    {
        meat_supply = meat_qte;
        grass_supply = grass_qte;
    }

    public Supply()
    {
        meat_supply = 2000;
        grass_supply = 2000;
    }

    public boolean status()
    {
        if (meat_supply <= 0 && grass_supply <= 0)
            return true;
        return false;
    }

    public int add_meat(int qte)
    {
        meat_supply += qte;
        return meat_supply;
    }

    public int add_grass(int qte)
    {
        grass_supply += qte;
        return grass_supply;
    }

    public void consume_meat(int qte) throws NoMoreMeatException
    {
        if (meat_supply - qte < 0)
        {
            throw new NoMoreMeatException("No more food for the carnivorous !");
        }
        meat_supply -= qte;
    }

    public void consume_grass(int qte) throws NoMoreGrassException
    {
        if (grass_supply - qte < 0)
        {
            throw new NoMoreGrassException("No more food for the herbivorous !");
        }
        grass_supply -= qte;
    }

    /**
     * @return int return the meat_supply
     */
    public int getMeat_supply() {
        return meat_supply;
    }

    /**
     * @param meat_supply the meat_supply to set
     */
    public void setMeat_supply(int meat_supply) {
        this.meat_supply = meat_supply;
    }

    /**
     * @return int return the grass_supply
     */
    public int getGrass_supply() {
        return grass_supply;
    }

    /**
     * @param grass_supply the grass_supply to set
     */
    public void setGrass_supply(int grass_supply) {
        this.grass_supply = grass_supply;
    }

}