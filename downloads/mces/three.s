		AREA FACT, CODE, READONLY
		ENTRY
		
		LDR		R0, RESULT
		LDRB	R1, [R0]
		MOV 	R2, R1
		
UP		ADD		R1, R1, #-1
		CMP 	R1, #0
		BEQ		STORE
		MUL		R3, R2, R1
		MOV 	R2, R3
		B		UP
		
STORE	STR		R2, [R0, #4]

RESULT	DCD		0X40000000
		END