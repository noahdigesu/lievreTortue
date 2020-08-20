enum TypeAnimal {
  TORTUE, LIEVRE
}

class Tortue {

  private int avancée;
  private TypeAnimal type;


  Tortue() { this.type = TypeAnimal.TORTUE; this.avancée = 0; }

  public void avancer() { this.avancée += 1; }

  public boolean estArrivée() { return this.avancée == 6; }

  public int getAvancée() { return this.avancée; }

  public void resetAvancée() { this.avancée = 0; }

  public TypeAnimal getType() { return this.type; }

  @Override
  public String toString() {
    return "Je suis une tortue. 🐢";
  }

}


class Lievre {

  private boolean arrivé;
  private TypeAnimal type;


  Lievre() { this.type = TypeAnimal.LIEVRE; this.arrivé = false; }

  public void avancer() { this.arrivé = true; }

  public boolean estArrivé() { return this.arrivé; }

  public void resetAvancée() { this.arrivé = false; }

  public TypeAnimal getType() { return this.type; }

  @Override
  public String toString() {
    return "Je suis un lièvre. 🐇";
  }

}

class Dé {

  private int valeur;


  public void lancer() {

    this.valeur = (int)(Math.random() * ((6 - 1) + 1)) + 1;

  }

  public int getValeur() { return this.valeur; }

}

class LievreTortue {

  private Tortue tortue;
  private Lievre lievre;
  private Dé dé;


  LievreTortue() {

    tortue = new Tortue();
    lievre = new Lievre();
    dé = new Dé();

  }

  public Tortue getTortue() { return this.tortue; }

  public Lievre getLievre() { return this.lievre; }

  public Dé getDé() { return this.dé; }

  public void jouerCoup() {

    this.dé.lancer();
    System.out.println("🎲 Le dé est lancé. Il retourne la valeur " + dé.getValeur() + ".");

    if (dé.getValeur() != 6) this.tortue.avancer();
    else this.lievre.avancer();

  }

  public boolean estFini() {

    if (this.tortue.estArrivée() || this.lievre.estArrivé()) return true;
    else return false;

  }

  public String getVainqueur() {

    String vainqueur = null;

    if (this.tortue.estArrivée()) vainqueur = "\n🐢 La tortue a gagné!\n+++++++++++++++++++++";
    if (this.lievre.estArrivé()) vainqueur = "\n🐇 Le lièvre a gagné!\n+++++++++++++++++++++";

    return vainqueur;

  }

  public void resetAvancée() {

    this.tortue.resetAvancée();
    this.lievre.resetAvancée();

  }

  public String afficherRègles() {

    return  "\n+--------------------------------------------------------------------------+\n" +
            "| 📖 Les règles du jeu sont très simple:                                   |\n" +
            "| Un dé 🎲 à 6 faces est lancé sur un plateau 🗺️  à 6 cases.                |\n" +
            "| Le premier arrivé à la dernière case remporte la partie 🤩.              |\n" +
            "| Si la valeur du dé est autre que 6, la tortue 🐢 avance de 1 case.       |\n" +
            "| Si au contraire la valeur du dé est de 6 (et 6 seulement), le lièvre 🐇  |\n" +
            "| avance directement à la 6ème case et gagne 🏆.                           |\n" +
            "+--------------------------------------------------------------------------+\n";

  }

  public static void main(String[] args) {

    LievreTortue game = new LievreTortue();

    System.out.println(game.afficherRègles());
    System.out.println("\n🎮 Un jeu de trois parties commence! Qui gagnera? Le lièvre 🐇? Ou la tortue 🐢...\n");

    for (int i = 0; i < 3; i++) {

      while (!game.estFini()) {

        game.jouerCoup();
        if (game.getVainqueur() != null) System.out.println(game.getVainqueur());

      }


      if (game.estFini()) {

        System.out.println("\n");
        game.resetAvancée();

      }

    }

  }

}
