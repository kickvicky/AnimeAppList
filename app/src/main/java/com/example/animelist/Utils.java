package com.example.animelist;

import java.util.ArrayList;



public class Utils {
    private static Utils instance;

    private static ArrayList<Anime> aList;
    private static ArrayList<Anime> aWatchedList;
    private static ArrayList<Anime> aWantList;
    private static ArrayList<Anime> aCurrList;
    private static ArrayList<Anime> aFavList;


    private Utils(){
        if(null==aList){
            aList = new ArrayList<>();
            initData();
        }
        if(null==aWatchedList){
            aWatchedList = new ArrayList<>();
        }
        if(null==aWantList){
            aWantList = new ArrayList<>();
        }
        if(null==aCurrList){
            aCurrList = new ArrayList<>();
        }
        if(null==aFavList){
            aFavList = new ArrayList<>();
        }
    }

    private void initData(){
        aList.add(new Anime(1,"Naruto","Masashi Kishimoto",220,"https://upload.wikimedia.org/wikipedia/en/9/94/NarutoCoverTankobon1.jpg","Shounen Adventure fiction","Underdog Ninja becomes president"));
        aList.add(new Anime(2,"Dragon Ball Z","Akira Toriyama",290,"https://m.media-amazon.com/images/M/MV5BMGMyOThiMGUtYmFmZi00YWM0LWJiM2QtZGMwM2Q2ODE4MzhhXkEyXkFqcGdeQXVyMjc2Nzg5OTQ@._V1_.jpg","Shounen Action","Saiyan race supremacy"));
        aList.add(new Anime(3,"Death note","Tsugumi Ohba",39,"https://static.wikia.nocookie.net/listofdeaths/images/8/8c/Death_Note_Poster.jpg","Shounen Thriller","Cat and mouse between IQ gods"));
        aList.add(new Anime(4,"Re:Zero","Tappei Nagatsuki",26,"https://m.media-amazon.com/images/M/MV5BN2NlM2Y5Y2MtYjU5Mi00ZjZiLWFjNjMtZDNiYzJlMjhkOWZiXkEyXkFqcGdeQXVyNjc2NjA5MTU@._V1_.jpg","Isekai","Wannabe harem protagonist gets isekaied"));
        aList.add(new Anime(5,"Jujutsu kaisen","Gege sensei",25,"https://cdn.myanimelist.net/images/anime/1171/109222.jpg","Shounen Dark magic","Curse king takes residence in \nProtagonist's body"));
        aList.add(new Anime(6,"One piece","Eiichiro Oda",980,"https://cdn.myanimelist.net/images/anime/6/73245.jpg","Shounen Adventure","Rubber boy and friends try\nfinding a mystical fruit"));
        aList.add(new Anime(7,"Gintama","Hideaki Sorachi",353,"https://cdn.myanimelist.net/images/anime/4/50361.jpg","Shounen Action comedy","Gin in feudal japan looses it"));
        aList.add(new Anime(8,"Hunter X Hunter","Yoshihiro Togashi",151,"https://cdn.myanimelist.net/images/anime/11/33657.jpg","Shounen Adventure","Hide & Seek Extreme to find Dad"));
        aList.add(new Anime(9,"Pokemon","Satoshi Tajiri",890,"https://cdn.myanimelist.net/images/anime/13/73834.jpg","Shounen Adventure","Eternal 10 year old wants to become\nbest in the world"));
        aList.add(new Anime(10,"Demon Slayer","Koyoharu Gotouge",25,"https://cdn.myanimelist.net/images/anime/1286/99889.jpg","Shounen Action","Tanjiro & friends fight Michael Jackson"));
        aList.add(new Anime(11,"Dr.Stone","Riichiro Inagaki",35,"https://cdn.myanimelist.net/images/anime/1613/102576.jpg","Shounen Sci-Fi","Brilliant boy Un-petrifies the world with his friends"));
        aList.add(new Anime(12,"Tokyo Ghoul","Sui Ishida",60,"https://cdn.myanimelist.net/images/anime/5/64449.jpg","Shounen Dark drama","First date gone wrong"));
        aList.add(new Anime(13,"Attack On Titan","Hajime Isayama",80,"https://m.media-amazon.com/images/M/MV5BMTY5ODk1NzUyMl5BMl5BanBnXkFtZTgwMjUyNzEyMTE@._V1_.jpg","Senin Dark Action","Emo boy wants Freedom"));
        aList.add(new Anime(14,"Rent A Girlfriend","Reiji Miyajima",12,"https://images-na.ssl-images-amazon.com/images/I/51kRA9dZDJL._SX346_BO1,204,203,200_.jpg","Romantic comedy","Protagonist rents a girlfriend to cure depression"));
        aList.add(new Anime(15,"My Hero Academia","Kohei Horikoshi",70,"https://m.media-amazon.com/images/M/MV5BNmQzYmE2MGEtZjk4YS00YmVjLWEwZWMtODRkMjc4MTM5N2I3XkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_.jpg","Shounen Superhero Fantasy","Wimp boy eats hair to become Superman"));
    }

    public static ArrayList<Anime> getAList() {
        return aList;
    }

    public static ArrayList<Anime> getAWatchedList() {
        return aWatchedList;
    }

    public static ArrayList<Anime> getAWantList() {
        return aWantList;
    }

    public static ArrayList<Anime> getACurrList() {
        return aCurrList;
    }

    public static ArrayList<Anime> getAFavList() {
        return aFavList;
    }

    public static Utils getInstance(){
        if(null != instance){
            return instance;
        }
        else{
            instance = new Utils();
            return instance;
        }

    }

    public Anime getAnimeByID(int id){
        for(Anime a: aList){
            if(a.getId()==id)return a;
        }
        return null;
    }

    public boolean addToCompleted(Anime a){
        return aWatchedList.add(a);
    }

    public boolean wantToWatch(Anime a){
        return aWantList.add(a);
    }

    public boolean favList(Anime a){
        return aFavList.add(a);
    }

    public boolean currList(Anime a){
        return aCurrList.add(a);
    }

    public boolean remCompleted(Anime a){
        return aWatchedList.remove(a);
    }

    public boolean remWantToWatch(Anime a){
        return aWantList.remove(a);
    }

    public boolean remFav(Anime a){
        return aFavList.remove(a);
    }
    public boolean remCurr(Anime a){
        return aCurrList.remove(a);
    }

}
