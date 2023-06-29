package epicode.capstone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import epicode.capstone.entities.Categoria;
import epicode.capstone.entities.Film;
import epicode.capstone.repositories.FilmsRepository;

@Component
public class FilmRunner implements CommandLineRunner {
	@Autowired
	FilmsRepository filmRepo;

	@Override
	public void run(String... args) throws Exception {
		List<Film> filmDB = filmRepo.findAll();
		if (filmDB.size() == 0) {
			Film film1 = new Film("Aquaman", "https://i.imgur.com/ydO73kB.jpg", Categoria.AZIONE,
					"Aquaman di James Wan si immerge nell'oceano ma non si distingue dai film supereroistici convenzionali. Una trama prevedibile, personaggi stereotipati e una regia frammentata limitano l'esperienza. Sequenze d'azione spettacolari e buoni effetti visivi non compensano la mancanza di originalità e coinvolgimento.",
					"3/5", "2h 23m", "2018", "https://www.youtube.com/embed/moNv1SlFneI");

			Film film2 = new Film("Super Mario Bros", "https://i.imgur.com/gGmic94.jpg", Categoria.ANIMAZIONE,
					"Super Mario, il famoso idraulico, e Luigi si ritrovano in un mondo magico. Luigi viene rapito da Bowser, mentre Mario cerca di salvarlo. Il film animato offre una narrazione piatta ma con elementi tecnici di qualità, presentando una principessa Peach attiva e un Luigi con un percorso formativo diverso. Mario rappresenta le insicurezze sociali contemporanee.",
					"3.5/5", "1h 32m", "2023", "https://www.youtube.com/embed/eyOP-gA4tIo");

			Film film3 = new Film("John Wick 4", "https://i.imgur.com/6Q12zQQ.jpg", Categoria.AZIONE,
					"John Wick, l'implacabile assassino, torna per vendicarsi della Gran Tavola della fantamafia. Senza una trama definita, il film si basa su lotte spettacolari e adrenalina costante. Il regista Chad Stahelski celebra gli stuntman e crea un'epica contemporanea senza compromessi. Una saga che consacra Stahelski come autore nel genere d'azione.",
					"4.5/5", "2h 49m", "2023", "https://www.youtube.com/embed/1-E33mUItH0");

			Film film4 = new Film("Star Wars: L'attacco dei cloni", "https://i.imgur.com/karn0mi.jpg",
					Categoria.FANTASCIENZA,
					"In Star Wars: L'attacco dei cloni, il secondo capitolo della trilogia prequel, l'Ordine dei Jedi affronta una crescente minaccia separatista. Obi-Wan Kenobi e Anakin Skywalker sono inviati in una missione per proteggere la senatrice Padmé Amidala e scoprire l'origine dell'esercito di cloni. Nel frattempo, Anakin si innamora di Padmé e affronta le tentazioni del lato oscuro della Forza. La trama si sviluppa con intrighi politici, battaglie intergalattiche e il misterioso piano del Signore Oscuro dei Sith, Darth Sidious.",
					"2.6/5", "2h 22m", "2002", "https://www.youtube.com/embed/ubC8cun7Tv0");

			Film film5 = new Film("Lo hobbit: Un viaggio inaspettato", "https://i.imgur.com/FFcoNKl.jpg",
					Categoria.FANTASY,
					"Lo Hobbit: Un viaggio inaspettato è un avventuroso film fantasy. Bilbo Baggins viene coinvolto da Gandalf il Grigio in una missione per recuperare il Regno dei Nani di Erebor. Unendosi a una compagnia di tredici nani guidata da Thorin Scudodiquercia, affrontano pericoli, creature malvagie e un incontro inaspettato con Gollum, nel tentativo di reclamare il tesoro nascosto e sconfiggere il terribile drago Smaug.",
					"3/5", "2h 49m", "2012", "https://www.youtube.com/embed/C3_RqRPF-OY");

			Film film6 = new Film("Tolo Tolo", "https://i.imgur.com/jmPMWgD.jpg", Categoria.COMMEDIA,
					"Checco Zalone interpreta Pieraccioni, un giovane italiano che emigra in Africa per cercare lavoro, sperando di migliorare la sua vita. Tuttavia, si trova coinvolto in una serie di situazioni comiche e imbarazzanti, mentre cerca disperatamente di adattarsi alla cultura e alle tradizioni locali. Un viaggio che gli permetterà di confrontarsi con se stesso e di scoprire il vero significato della felicità.",
					"3.5/5", "1h 43m", "2020", "https://www.youtube.com/embed/we1sS9EJt8w");

			Film film7 = new Film("Shazam!", "https://i.imgur.com/9Bheuav.jpg", Categoria.AZIONE,
					"Thaddeus, trascurato dalla famiglia, viene provato dal mago Shazam, ma soccombe alle tentazioni. Anni dopo, ottiene poteri oscuri, mentre il mago trova un nuovo campione virtuoso. Quando Thaddeus pronuncia \"Shazam!\", diventa un eroe pronto a combattere per il mondo.",
					"3/5", "2h 12m", "2019", "https://www.youtube.com/embed/adZfOjkaRWs");

			Film film8 = new Film("Luca", "https://i.imgur.com/0bADGjF.jpg", Categoria.ANIMAZIONE,
					"Luca, una creatura marina dedita alla pastorizia subacquea, incontra un suo simile, Alberto, insieme al quale, sotto sembianze umane, si avventura verso Portorosso, un villaggio di pescatori della riviera ligure. L’incontro con Giulietta e la partecipazione ad una gara mette a repentaglio il loro segreto.",
					"4.5/5", "1h 35m", "2021", "https://www.youtube.com/embed/HQ6Dhr9rIIk");

			Film film9 = new Film("Shutter Island", "https://i.imgur.com/aHpHA72.jpg", Categoria.THRILLER,
					"1954. L’agente federale Teddy Daniels si reca a Shutter Island, al largo di Boston, dove si trova l’Ashecliffe Hospital, un manicomio criminale. Deve ritrovare una detenuta scomparsa, Rachel Salando. Un uragano si abbatte sull’isola…",
					"3/5", "2h 18m", "2010", "https://www.youtube.com/embed/mzkVNB3FpSQ");

			Film film10 = new Film("Creed 3", "https://i.imgur.com/pjMcwyY.jpg", Categoria.DRAMMATICO,
					"Adonis Creed sta prosperando nella sua carriera e nella sua vita familiare. Quando un amico d’infanzia ed ex prodigio del pugilato ricompare dopo aver scontato la pena in carcere, ansioso di dimostrare di meritare la sua occasione sul ring, la situazione sfuggirà presto di mano…",
					"2.5/5", "1h 56m", "2023", "https://www.youtube.com/embed/glC10RPu7tY");
			filmRepo.save(film1);
			filmRepo.save(film2);
			filmRepo.save(film3);
			filmRepo.save(film4);
			filmRepo.save(film5);
			filmRepo.save(film6);
			filmRepo.save(film7);
			filmRepo.save(film8);
			filmRepo.save(film9);
			filmRepo.save(film10);

		}
	}

}
