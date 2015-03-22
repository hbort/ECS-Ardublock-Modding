package com.ardublock.translator.block.exception;

import com.ardublock.translator.block.exception.SocketNullException;

public class InvalidNumberVariableNameException extends SocketNullException
{
	private Long blockId;
	private String varName;
	
	public InvalidNumberVariableNameException(Long blockId, String varName)
	{
		super(blockId);
		this.varName = varName;
	}
	
	public Long getBlockId()
	{
		return blockId;
	}

	public String getMessage() {
		return varName;
	}

}
