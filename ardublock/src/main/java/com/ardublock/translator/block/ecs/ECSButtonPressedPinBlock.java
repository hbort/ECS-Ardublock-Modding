package com.ardublock.translator.block.ecs;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.InvalidPinException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;
import com.ardublock.core.exception.ArdublockException;

public class ECSButtonPressedPinBlock extends TranslatorBlock
{
	public ECSButtonPressedPinBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws ArdublockException
	{
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
	
		String number;
		number = translatorBlock.toCode();

		if (!(number.trim().equals(BUTTON_PIN_1)) && !(number.trim().equals(BUTTON_PIN_2))
			&& !(number.trim().equals(BUTTON_PIN_3)) && !(number.trim().equals(BUTTON_PIN_4))
			&& !(number.trim().equals(FREE_PIN_1)) && !(number.trim().equals(FREE_PIN_2))
			&& !(number.trim().equals(FREE_PIN_3)) && !(number.trim().equals(FREE_PIN_4))
			&& !(number.trim().equals(FREE_PIN_5)) && !(number.trim().equals(FREE_PIN_6))) {
			throw new InvalidPinException(blockId);
		}

		translator.addInputPin(number.trim());

		String ret = "digitalRead(";
		ret = ret + number;
		ret = ret + ")";
		return codePrefix + ret + codeSuffix;
	}
}
