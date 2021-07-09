package homework4;

/**
 * Figure interface for various types of figures
 * has single method getFigure()
 */
interface Figure{
    void getFigure();
}

/**
 * implements interface Figure and overrides method getFigure
 */
class UpwardHat implements Figure{

    @Override
    public void getFigure() {
        System.out.print("/\\");
    }
}

/**
 * implements interface Figure and overrides method getFigure
 */
class DownwardHat implements Figure{

    @Override
    public void getFigure() {
        System.out.print("\\/");
    }
}

/**
 * implements interface Figure and overrides method getFigure
 */
class FaceMaker implements Figure{

    @Override
    public void getFigure() {
        System.out.print(":)");
    }
}

/**
 * implements interface Figure and overrides method getFigure
 */
class Vertical implements Figure{

    @Override
    public void getFigure() {
        System.out.print("||");
    }
}

/**
 * implements interface Figure and overrides method getFigure
 */
public class FigureInterfaceProblem3 {
    public static void main(String[] args){
        Figure[] figureArray = new Figure[4];
        figureArray[0] = new UpwardHat();
        figureArray[1] = new DownwardHat();
        figureArray[2] = new FaceMaker();
        figureArray[3] = new Vertical();

        for (Figure figure : figureArray){
            figure.getFigure();
            System.out.print(" ");
            if(figure instanceof UpwardHat){
                figure.getFigure(); // because upward hat should be displayed two times
                System.out.print(" ");
            }
        }

        System.out.println();
        for (Figure figure : figureArray){
            System.out.print(figure.getClass().getSimpleName() + " : ");
            figure.getFigure();
            System.out.println();
            if(figure instanceof UpwardHat){
                System.out.print(figure.getClass().getSimpleName() + " : ");
                figure.getFigure(); // because upward hat should be displayed two times
                System.out.println();
            }
        }

    }
}
