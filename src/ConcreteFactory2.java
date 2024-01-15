
//crea post random

public class ConcreteFactory2 extends AbstractPostFactory implements CondividiStrategy{
    @Override
    public Post creaVideoPost(){

        return new VideoPost(PostTag.RANDOM);
    }

    @Override
    public Post creaImagePost() {

        return new ImagePost(PostTag.RANDOM);
    }

    @Override
    public Post share(PostType pty) {
        switch (pty){
            case IMAGE:
                return creaImagePost();
            case VIDEO:
                return creaVideoPost();
        }
        return null;
    }
}
