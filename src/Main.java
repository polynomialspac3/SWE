import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Observer o = new Observer();
        //VideoPost vp = new VideoPost(PostTag.RANDOM);
        //ImagePost ip = new ImagePost(PostTag.RANDOM);
        int vlikes, vviews, ilikes = 0;
        Post similarpost;
        int n = 30;


        Post[] archive = new Post[n];

        //creaiamo i primi 20 post di tutte le 4 tipologie

        for(int i=0; i<20; i++){
            if (i < 5) {
                VideoPost videop = new VideoPost((PostTag.TRENDING));
                videop.setLikes();
                videop.setViews();
                archive[i] = videop;
            }else if(i <10){
                VideoPost videop = new VideoPost((PostTag.RANDOM));
                videop.setLikes();
                videop.setViews();
                archive[i] = videop;
            } else if(i <15){
                ImagePost imagep = new ImagePost((PostTag.RANDOM));
                imagep.setLikes();
                archive[i] = imagep;
            } else if (i<20) {
                ImagePost imagep = new ImagePost((PostTag.TRENDING));
                imagep.setLikes();
                archive[i] = imagep;
            }
        }


        //ORDINA IN BASE AI LIKE
        Post mostliked = archive[0];
        for(int i=0; i<20; i++){
            if (archive[i].getLikes() > mostliked.getLikes()){
                mostliked = archive[i];
            }
        }
        mostliked.notifyObserver(o);
        similarpost = o.executeStrategy();
        similarpost.setLikes();
        if(similarpost.getType() == PostType.VIDEO){
            ((VideoPost) similarpost).setViews();
        }
        archive[20] = similarpost;

        System.out.println("most liked  " + mostliked + "likes  " + mostliked.getLikes());

        VideoPost mostviewed = (VideoPost)archive[0];
        for(int i=0; i<10; i++){
            if ( ((VideoPost)archive[i]).getViews() > mostviewed.getViews()){
                mostviewed = (VideoPost) archive[i];
            }
        }

        System.out.println("most viewed  " + mostviewed + "likes  " + mostviewed.getViews());

        mostviewed.notifyObserver(o);
        similarpost = o.executeStrategy();
        similarpost.setLikes();
        if(similarpost.getType() == PostType.VIDEO){
            ((VideoPost) similarpost).setViews();
        }

        archive[21] = similarpost;

        for(int i=0; i<22; i++){
            if(archive[i].getType()==PostType.VIDEO){
                int v = ((VideoPost)archive[i]).getViews();
                System.out.println("post numero " + i  + "  " + archive[i] + " likes  " + archive[i].getLikes() + "  views " + v);
            }else {
                System.out.println("post numero " + i + "  " + archive[i] + " likes  " + archive[i].getLikes());
            }
        }

    }


}