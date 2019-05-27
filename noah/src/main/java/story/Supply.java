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
}