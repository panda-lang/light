// LightCore
:LightCore
	* Core
    	* Expression:
    	    * types:
    	        - default expression // e.g. panda version
    	        - expression initializer // e.g. {var}
    	        - individual expression //
    	        - argument // event-player
        	- modify
        	- getValue
        * Phrase:
        	- run
        * Type:
        	- serialize
            - deserialize

	* API
    	- registerPhraseRepresentation
        * registerExpressionRepresentation()
            -> default expression
            -> individual expression
        - registerType
        * registerStructure:
        	> initialize elements
            	: type
                : expressionRepresentations
                : phraseRepresentations
        - registerLightBlock

    * Ray
    	- expressions
        - expression runtimes
        - pattern index

    * Parser
    	> ExpressionParser
        	: Expressions
        	    :: default expressions
        	    :: individual expressions
        	    :: arguments
            : Types
            : Essence


// LightPlugin
:LightPlugin
	* API:
    	- <LightCore::API>
    	- registerEvent
    * Lang:
    	* Structures:
        	- Player
            - Block
        - Events
        - Tasks



general:
----------------------------------------------------------------------

// scope
on join {
 	// argument (expression)
	player
    // phrase
    kick player
    // expression
    player name
}


parse:
----------------------------------------------------------------------

// event
parse("on join"): {
	parse("set <var> to player name") {
    	parse("<var>") {
        	return Variable;
        }
        parse("player name") {
        	return Argument;
        }
    }
}


runtime:
-----------------------------------------------------------------------

// scope (event)
call("on join"): {
	todo: set arguments to objects
    run {
    	// code
    }

}
