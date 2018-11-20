import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ArrayList<String> a = new ArrayList<>();

        ArrayList<State> states = new ArrayList<>();
        states.add(new State(s));
        while(!states.isEmpty()) {
            State t = states.get(0);
            states.remove(0);
            if(t.isDone()) {
                a.add(t.current);
            } else {
                states.addAll(t.getNextStates());
            }
        }

        Collections.sort(a);
        for(String str : a) {
            System.out.println(str);
        }
    }
}

class State {
    String current;
    String code;

    public State(String code) {
        this.current = "";
        this.code = code;
    }

    public State(String current, String code) {
        this.current = current;
        this.code = code;
    }

    public ArrayList<State> getNextStates() {
        ArrayList<State> a = new ArrayList<>();
        if(code.length() > 0) {
            switch (code.substring(0, 1)) {
                case "-":
                    a.add(new State(current + 'A', code.substring(1)));
                    break;
                case ".":
                    a.add(new State(current + 'E', code.substring(1)));
                    break;
            }

            if(code.length() > 1) {
                switch (code.substring(0, 2)) {
                    case "-.":
                        a.add(new State(current + 'I', code.substring(2)));
                        break;
                    case "":
                        a.add(new State(current + 'O', code.substring(2)));
                        break;
                    case "--":
                        a.add(new State(current + 'U', code.substring(2)));
                        break;
                }

                if(code.length() > 2) {
                    switch (code.substring(0, 3)) {
                        case "--.":
                            a.add(new State(current + 'B', code.substring(3)));
                            break;
                        case ".--":
                            a.add(new State(current + 'C', code.substring(3)));
                            break;
                        case "-.-":
                            a.add(new State(current + 'D', code.substring(3)));
                            break;
                        case "..-":
                            a.add(new State(current + 'F', code.substring(3)));
                            break;
                        case "---":
                            a.add(new State(current + 'J', code.substring(3)));
                            break;
                        case "...":
                            a.add(new State(current + 'K', code.substring(3)));
                            break;
                        case ".-.":
                            a.add(new State(current + 'L', code.substring(3)));
                            break;
                    }

                    if(code.length() > 3) {
                        switch (code.substring(0, 4)) {
                            case "---.":
                                a.add(new State(current + 'G', code.substring(4)));
                                break;
                            case "..--":
                                a.add(new State(current + 'H', code.substring(4)));
                                break;
                            case ".-.-":
                                a.add(new State(current + 'M', code.substring(4)));
                                break;
                            case ".-..":
                                a.add(new State(current + 'N', code.substring(4)));
                                break;
                            case ".--.":
                                a.add(new State(current + 'P', code.substring(4)));
                                break;
                            case "--..":
                                a.add(new State(current + 'Q', code.substring(4)));
                                break;
                        }

                        if(code.length() > 4) {
                            switch (code.substring(0, 5)) {
                                case ".-..-":
                                    a.add(new State(current + 'R', code.substring(5)));
                                    break;
                                case "....-":
                                    a.add(new State(current + 'S', code.substring(5)));
                                    break;
                                case "-..--":
                                    a.add(new State(current + 'T', code.substring(5)));
                                    break;
                                case "-.-..":
                                    a.add(new State(current + 'V', code.substring(5)));
                                    break;
                                case "--..-":
                                    a.add(new State(current + 'W', code.substring(5)));
                                    break;
                                case ".-.-.":
                                    a.add(new State(current + 'X', code.substring(5)));
                                    break;
                                case ".....":
                                    a.add(new State(current + 'Y', code.substring(5)));
                                    break;
                                case "-----":
                                    a.add(new State(current + 'Z', code.substring(5)));
                                    break;
                            }
                        }
                    }
                }
            }
        }
//            switch(code.charAt(0)) {
//                case '-':
//                    a.add(new State(current + 'Test', code.substring(1)));
//                        if(code.length() > 1) {
//                            switch(code.charAt(1)) {
//                                case '-':
//                                    a.add(new State(current + 'U', code.substring(2)));
//                                    if(code.length() > 2) {
//
//                                    }
//                                    break;
//                                case '.':
//                                    break;
//                            }
//                        }
//                    break;
//                case '.':
//                    break;
//            }
        return a;
    }

    public boolean isDone() {
        return code.length() == 0;
    }
}
