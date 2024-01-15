
//abstract product b

public abstract class AbstractImagePost implements Post{
    //Observer o = new Observer();
    int likes;
    @Override
    public int getLikes() {
        //System.out.println("likes" + likes);
        return likes;
    }

    public void setLikes(){
        this.likes = (int)(Math.random()*(1000-1));
        /*System.out.println("likes" + likes);
        if(likes > 300){
            this.notifyObserver(o);
        }*/
    }

    @Override
    public void prova() {
        System.out.println("imagepost");
    }
}
