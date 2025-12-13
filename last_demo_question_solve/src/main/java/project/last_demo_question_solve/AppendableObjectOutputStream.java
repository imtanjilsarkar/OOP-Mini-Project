package project.last_demo_question_solve;


import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import static java.lang.System.out;


public class AppendableObjectOutputStream extends ObjectOutputStream {
    public AppendableObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    protected void writeStreamHeader () throws IOException {

    }
}
