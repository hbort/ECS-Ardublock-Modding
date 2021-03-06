package ecs.unittest;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.*;
import com.ardublock.translator.block.ecs.*;
import com.ardublock.translator.block.exception.*;

import edu.mit.blocks.controller.WorkspaceController;
import edu.mit.blocks.workspace.Workspace;

import static org.testng.Assert.*;

import org.testng.annotations.*;

public class LedOff4Test
{

	private static final String LED_PIN_4 = TranslatorBlock.LED_PIN_4;
	private static final String LED4_TOCODE = "digitalWrite( " + LED_PIN_4 + " , LOW);\n";
	private static final String[] LED4_SETUP_COMMANDS = {"pinMode( " + LED_PIN_4 + ", OUTPUT);\n"};
	private static final String[] LED4_DEFINITIONS = {};

	private ECSLedOff4 blockToTest;
	private Translator translator;

	@BeforeClass
	public void setUp()
	{
		translator = ECSTestUtil.getNewTranslator();
	}

	
	@Test
	public void ledOff4Test_noInput_Success() {
		blockToTest = new ECSLedOff4(ECSTestUtil.TEST_ID, translator, "", "", "");
	
		try {	
			assertEquals(blockToTest.toCode(), LED4_TOCODE);
			assertTrue(ECSTestUtil.headersMatch(translator.genreateHeaderCommand(), LED4_DEFINITIONS, LED4_SETUP_COMMANDS));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
