/* Generated By:JavaCC: Do not edit this line. KEGGOrthologyParser.java */
package de.fxe.parser.KEGG;

import java.util.List;
import java.util.ArrayList;

import de.fxe.parser.AuxUtilities;

//@SuppressWarnings("unused")
public class KEGGOrthologyParser implements KEGGOrthologyParserConstants {
  public static boolean VERBOSE = false;

  final public List<List<String >> parseDefinition() throws ParseException {
  List<List<String >> aux;
  List<List<String >> ret = new ArrayList<List<String >>();
    label_1:
    while (true) {
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 8:
          ;
          break;
        default:
          jj_la1[0] = jj_gen;
          break label_2;
        }
        jj_consume_token(8);
      }
      aux = DEF_ELEMENT();
        if (VERBOSE) System.out.println("DEF_ELEMENT: " + aux);
                ret.addAll(aux);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ID:
      case 8:
      case 9:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_1;
      }
    }
    jj_consume_token(0);
        {if (true) return ret;}
    throw new Error("Missing return statement in function");
  }

  final public List<List<String >> DEF_ELEMENT() throws ParseException {
  String op;
  List<List<String >> aux;
  List<List<String >> ret = null;
    ret = EXPR();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_3;
      }
      op = OP();
      aux = EXPR();
          if (VERBOSE) {
            System.out.println(ret);
            System.out.println(op);
                System.out.println(aux);
          }
          ret = AuxUtilities.cartStringConcatProd2(ret, aux, op);
    }
    {if (true) return ret;}
    throw new Error("Missing return statement in function");
  }

  final public String OP() throws ParseException {
  Token op;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
      op = jj_consume_token(PLUS);
      break;
    case MINUS:
      op = jj_consume_token(MINUS);
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
        {if (true) return op.toString();}
    throw new Error("Missing return statement in function");
  }

  final public List<List<String >> EXPR() throws ParseException {
  List<List<String >> ret = null;
  String termId = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      termId = TERMINAL_ID();
    ret = new ArrayList<List<String >>();
        List<String > singleTon = new ArrayList<String >();
        singleTon.add(termId);
        ret.add(singleTon);
    {if (true) return ret;}
      break;
    case 9:
      jj_consume_token(9);
      ret = EXPR_ELEMENTS();
      jj_consume_token(10);
    {if (true) return ret;}
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  final public List<List<String >> EXPR_ELEMENTS() throws ParseException {
        List<List<String >> ret = new ArrayList<List<String >> ();
        List<List<String >> elemSet = null;
        List<List<String >> aux = null;
    elemSet = DEF_ELEMENT();
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ID:
      case 8:
      case 9:
        ;
        break;
      default:
        jj_la1[5] = jj_gen;
        break label_4;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 8:
        jj_consume_token(8);
        aux = DEF_ELEMENT();
      elemSet = AuxUtilities.cartesianProduct(elemSet, aux);
      if (VERBOSE) System.out.println("ELEMSET:" + elemSet);

       //List<List<List<String >>> prod = new ArrayList<List<List<String >>> ();
       //List<List<String >> last = 
       //prod.add()
       //List<String >  = ret.get( ret.size() - 1);
       //AuxUtilities.cartProd();

        break;
      case ID:
      case 9:
        aux = DEF_ELEMENT();
      ret.addAll(elemSet);
      elemSet.clear();
      elemSet.addAll(aux);
        break;
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    if ( !elemSet.isEmpty()) ret.addAll(elemSet);
    if (VERBOSE) System.out.println("EXPR_ELEMENTS:" + ret);
        {if (true) return ret;}
    throw new Error("Missing return statement in function");
  }

  final public String TERMINAL_ID() throws ParseException {
  Token id;
    id = jj_consume_token(ID);
    {if (true) return id.toString();}
    throw new Error("Missing return statement in function");
  }

  /** Generated Token Manager. */
  public KEGGOrthologyParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private int jj_gen;
  final private int[] jj_la1 = new int[7];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x100,0x380,0x60,0x60,0x280,0x380,0x380,};
   }

  /** Constructor with InputStream. */
  public KEGGOrthologyParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public KEGGOrthologyParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new KEGGOrthologyParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public KEGGOrthologyParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new KEGGOrthologyParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public KEGGOrthologyParser(KEGGOrthologyParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(KEGGOrthologyParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[11];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 7; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 11; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

}
