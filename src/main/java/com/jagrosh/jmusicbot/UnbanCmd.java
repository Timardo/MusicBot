package com.jagrosh.jmusicbot;

import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jmusicbot.commands.OwnerCommand;
import com.jagrosh.jmusicbot.settings.Settings;

public class UnbanCmd extends OwnerCommand {
    public UnbanCmd(Bot bot)
    {
        this.name = "unban";
        this.arguments = "<mention/s>";
        this.help = "unban people from using the bot";
        this.aliases = bot.getConfig().getAliases(this.name);
    }
    
    @Override
    protected void execute(CommandEvent event) {
        if(event.getEvent().getMessage().getMentionedUsers().isEmpty())
        {
            event.reply(event.getClient().getError()+" Please include a valid mention/s to user/s you want to unban");
            return;
        }
        Settings s = event.getClient().getSettingsFor(event.getGuild());
        event.getEvent().getMessage().getMentionedUsers().forEach((user) -> s.unbanUser(user));
        event.reply(event.getClient().getSuccess()+" Mentioned user/s successfully unbanned!");
    }
    
}
