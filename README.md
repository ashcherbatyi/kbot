# Telegram Bot

This is a simple Telegram bot implemented in Golang.

## Installation (you should have GoLang version >= 1.22 installed)

1. Clone the repository:

        git clone https://github.com/ashcherbatyi/kbot.git
        cd kbot

2. Install dependencies:

        go mod tidy

3. Create a Telegram bot using BotFather:

        Open Telegram and find BotFather.
        Use the command /newbot to create a new bot.
	Name should be <YourBotName>_bot
        Save the token provided by BotFather.

4. Add your token to the environment:

        export TELE_TOKEN="your-telegram-bot-token"

5. Modify `main.go`:

        import "github.com/<yourname>/kbot/cmd"

6. Run the bot:

        go build -ldflags "-X=github.com/<yourname>/kbot/cmd.appversion=v1.0.2"
        ./kbot start

## Usage

	You can interact with the bot at https://t.me/YourBotName_bot.
        Then push message:

        /start hello

        You will receive a response with the current version of the bot.
 
