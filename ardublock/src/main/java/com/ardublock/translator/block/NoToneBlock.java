package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.InvalidPinException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class NoToneBlock extends TranslatorBlock
{
	public NoToneBlock(Long blockId, Translator translator, String codePrefix,	String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		TranslatorBlock pinBlock = this.getRequiredTranslatorBlockAtSocket(0);

		if (!(pinBlock.toCode().equals(SPEAKER_PIN)) && !(pinBlock.toCode().equals(FREE_PIN_1))
			&& !(pinBlock.toCode().equals(FREE_PIN_2)) && !(pinBlock.toCode().equals(FREE_PIN_3))
			&& !(pinBlock.toCode().equals(FREE_PIN_4)) && !(pinBlock.toCode().equals(FREE_PIN_5))
			&& !(pinBlock.toCode().equals(FREE_PIN_6))) {
			throw new InvalidPinException(blockId);
		}

		String ret = "\tnoTone(" + pinBlock.toCode() + ");\n";
		return ret;
	}
}
