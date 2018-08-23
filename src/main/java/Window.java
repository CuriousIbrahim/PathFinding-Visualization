import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

public class Window extends Stage {

    private static final int GRID_ROW = 20;
    private static final int GRID_COLUMN = 20;


    private Button start;

    private GridPane mainPane;

    private GridPane grid;


    public Window() {

        mainPane = new GridPane();

        start = new Button("Start");

        grid = setUpGrid();

        mainPane.add(grid, 0, 0);

        mainPane.add(start, 0, 2);

        setScene(new Scene(mainPane));


    }

    private GridPane setUpGrid() {

        GridPane grid = new GridPane();

        for (int i = 0; i < GRID_ROW; i++) {
            for (int j = 0; j < GRID_COLUMN; j++) {
                Box box = new Box(2, 2, 1);

                Button button = new Button("   ");

                button.minHeight(100);
                button.minWidth(100);

                button.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

                grid.add(button, i, j);
            }
        }

//        grid.setHgap(1);
//        grid.setVgap(1);

        return grid;

    }


}
