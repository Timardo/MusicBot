package com.jagrosh.jmusicbot;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jmusicbot.commands.OwnerCommand;
import com.jagrosh.jmusicbot.settings.Settings;

public class BanCmd extends OwnerCommand
{
    public BanCmd(Bot bot)
    {
        this.name = "ban";
        this.arguments = "<mention/s>";
        this.help = "ban people from using the bot";
        this.aliases = bot.getConfig().getAliases(this.name);
    }

    @Override
    protected void execute(CommandEvent event) {
        if(event.getEvent().getMessage().getMentionedUsers().isEmpty())
        {
            event.reply(event.getClient().getError()+" Please include a valid mention/s to retarded user/s you want to ban");
            return;
        }
        Settings s = event.getClient().getSettingsFor(event.getGuild());
        event.getEvent().getMessage().getMentionedUsers().forEach((user) -> s.banUser(user));
        event.reply(event.getClient().getSuccess()+" Mentioned dick/s successfully banned!");
    }
}
