package com.kreggscode.aristotlequotes.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import com.kreggscode.aristotlequotes.ui.components.*
import com.kreggscode.aristotlequotes.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnhancedAboutScreen(
    onBackClick: () -> Unit,
    onWorkClick: ((String) -> Unit)? = null
) {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("Biography", "Works", "Legacy", "Timeline")
    
    // Handle back button - if on another tab, go to Biography first, then exit
    BackHandler(enabled = selectedTab != 0) {
        if (selectedTab != 0) {
            selectedTab = 0
        } else {
            onBackClick()
        }
    }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        PremiumColors.DeepSpace,
                        PremiumColors.MidnightBlue,
                        PremiumColors.DeepSpace
                    )
                )
            )
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            "About Aristotle",
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(
                                Icons.Default.ArrowBack,
                                contentDescription = "Back",
                                tint = Color.White
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.Transparent
                    )
                )
            },
            containerColor = Color.Transparent
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                // Tabs
                ScrollableTabRow(
                    selectedTabIndex = selectedTab,
                    containerColor = Color.Transparent,
                    contentColor = Color.White,
                    edgePadding = 16.dp
                ) {
                    tabs.forEachIndexed { index, title ->
                        Tab(
                            selected = selectedTab == index,
                            onClick = { selectedTab = index },
                            text = {
                                Text(
                                    title,
                                    fontWeight = if (selectedTab == index) FontWeight.Bold else FontWeight.Normal
                                )
                            }
                        )
                    }
                }
                
                // Content
                when (selectedTab) {
                    0 -> BiographyTab()
                    1 -> WorksTab(onWorkClick = onWorkClick)
                    2 -> LegacyTab()
                    3 -> TimelineTab()
                }
            }
        }
    }
}

@Composable
fun BiographyTab() {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            GlassmorphicCard(
                modifier = Modifier.fillMaxWidth(),
                glowColor = PremiumColors.ElectricPurple,
                animateGlow = true
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("🏛️", fontSize = 64.sp)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "Aristotle",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        "384 BC - 322 BC",
                        style = MaterialTheme.typography.titleMedium,
                        color = PremiumColors.CyberBlue
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "Philosopher, Scientist, and Polymath",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White.copy(alpha = 0.7f)
                    )
                }
            }
        }
        
        item {
            InfoCard(
                title = "Early Life",
                icon = "👶",
                content = "Born in 384 BC in Stagira, northern Greece. Son of Nicomachus, court physician to King Amyntas III of Macedon. Orphaned at a young age and raised by a guardian. Showed early intellectual promise."
            )
        }
        
        item {
            InfoCard(
                title = "Plato's Academy (367-347 BC)",
                icon = "🎓",
                content = "At age 17, joined Plato's Academy in Athens, the premier center of learning. Studied there for 20 years until Plato's death. Developed his own philosophical ideas while learning from the master."
            )
        }
        
        item {
            InfoCard(
                title = "Tutor to Alexander (343-335 BC)",
                icon = "👑",
                content = "Invited by King Philip II of Macedon to tutor his son, Alexander (later 'the Great'). Taught the young prince philosophy, politics, poetry, and science. This relationship shaped both their legacies."
            )
        }
        
        item {
            InfoCard(
                title = "The Lyceum (335-323 BC)",
                icon = "🏛️",
                content = "Founded his own school in Athens called the Lyceum. Conducted research and taught while walking in the school's covered walkways (peripatos), earning his followers the name 'Peripatetics'."
            )
        }
        
        item {
            InfoCard(
                title = "Final Years",
                icon = "📜",
                content = "After Alexander's death in 323 BC, anti-Macedonian sentiment forced Aristotle to flee Athens. Died in 322 BC in Chalcis at age 62, leaving behind an enormous body of work covering nearly every field of knowledge."
            )
        }
    }
}

@Composable
fun WorksTab(onWorkClick: ((String) -> Unit)? = null) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            HighlightCard(
                title = "The Golden Mean",
                subtitle = "Virtue as the Middle Path",
                description = "Aristotle's doctrine that moral virtue is a mean between extremes of excess and deficiency. Courage, for example, lies between cowardice and recklessness.",
                gradient = listOf(PremiumColors.PlasmaOrange, PremiumColors.NeonPink)
            )
        }
        
        item {
            Text(
                "Major Works",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
        
        val works = listOf(
            Work("Nicomachean Ethics", "-340 BC", "Comprehensive treatise on virtue, happiness, and the good life through practical wisdom", "⭐", "nicomachean_ethics"),
            Work("Politics", "-350 BC", "Analysis of political communities, constitutions, and the ideal state", "🏛️", "politics"),
            Work("Metaphysics", "-350 BC", "Investigation into being as being, substance, causality, and fundamental principles of reality", "🔍", "metaphysics"),
            Work("Physics", "-350 BC", "Foundational work on natural philosophy, exploring motion, change, time, and principles of the physical world", "🌌", "physics"),
            Work("Poetics", "-335 BC", "Analysis of poetry and drama, defining the elements of tragedy and its psychological impact", "🎭", "poetics"),
            Work("On the Soul (De Anima)", "-350 BC", "Investigation into the nature of the soul as the form and actuality of living bodies", "🧠", "on_the_soul"),
            Work("Rhetoric", "-350 BC", "Systematic analysis of persuasive speech as essential for civic life and discovering truth", "💬", "rhetoric"),
            Work("Categories", "-340 BC", "Analysis of the basic types of being and the structure of predication", "📂", "categories"),
            Work("Posterior Analytics", "-350 BC", "Analysis of scientific demonstration and how we gain certain knowledge from first principles", "🧮", "posterior_analytics"),
            Work("Prior Analytics", "-350 BC", "Creation of syllogistic logic - the first formal system of deductive reasoning", "⚙️", "prior_analytics"),
            Work("Generation of Animals", "-350 BC", "Detailed study of animal reproduction, heredity, and embryonic development", "🧬", "generation_of_animals"),
            Work("Parts of Animals", "-350 BC", "Analysis of animal anatomy and the functional purposes of biological structures", "🔬", "parts_of_animals"),
            Work("History of Animals", "-350 BC", "Massive compilation of observations about animal behavior, anatomy, and classification", "🐘", "history_of_animals"),
            Work("On Interpretation", "-350 BC", "Analysis of language, truth, and meaning, focusing on propositions and their relationship to reality", "💭", "on_interpretation"),
            Work("Eudemian Ethics", "-350 BC", "Alternative ethical system with different emphases than Nicomachean Ethics", "⚖️", "eudemian_ethics"),
            Work("Constitution of Athens", "-320 BC", "Historical analysis of Athenian constitutional development - only surviving work from 158 constitutions", "📜", "constitution_of_athens"),
            Work("Topics", "-350 BC", "Dialectical reasoning and argumentation", "🎯", null),
            Work("On the Heavens", "-350 BC", "Cosmology and astronomy", "🌟", null),
            Work("Meteorology", "-340 BC", "Weather, climate, and atmospheric phenomena", "⛈️", null),
            Work("On Memory", "-350 BC", "Psychology of memory and recollection", "🧩", null)
        )
        
        items(works) { work ->
            WorkCard(work = work, onClick = {
                work.id?.let { id -> onWorkClick?.invoke(id) }
            })
        }
    }
}

@Composable
fun LegacyTab() {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            InfoCard(
                title = "Philosophical Impact",
                icon = "🧠",
                content = "Founded formal logic and the scientific method. His systematic approach to knowledge influenced Western thought for over 2000 years. Created frameworks for ethics, politics, and metaphysics still studied today."
            )
        }
        
        item {
            InfoCard(
                title = "Scientific Contributions",
                icon = "🔬",
                content = "Father of biology through empirical observation of over 500 species. Pioneered comparative anatomy, embryology, and taxonomy. His biological works remained authoritative until the Renaissance."
            )
        }
        
        item {
            InfoCard(
                title = "Educational Legacy",
                icon = "📚",
                content = "The Lyceum became a model for universities. His method of systematic inquiry and classification shaped academic disciplines. Influenced Islamic Golden Age scholars who preserved and expanded his works."
            )
        }
        
        item {
            InfoCard(
                title = "Medieval Influence",
                icon = "⛪",
                content = "Thomas Aquinas synthesized Aristotelian philosophy with Christian theology. Became the foundation of Scholasticism. Universities in medieval Europe were built around his texts."
            )
        }
        
        item {
            InfoCard(
                title = "Modern Relevance",
                icon = "💡",
                content = "Virtue ethics experiencing revival in moral philosophy. His political analysis remains relevant to constitutional theory. Concepts like the golden mean influence psychology and decision-making."
            )
        }
    }
}

@Composable
fun TimelineTab() {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        val timeline = listOf(
            TimelineEvent("384 BC", "Born in Stagira, Greece", "👶"),
            TimelineEvent("367 BC", "Joined Plato's Academy in Athens", "🎓"),
            TimelineEvent("347 BC", "Plato dies; Aristotle leaves Academy", "📜"),
            TimelineEvent("343 BC", "Becomes tutor to Alexander the Great", "👑"),
            TimelineEvent("335 BC", "Returns to Athens, founds the Lyceum", "🏛️"),
            TimelineEvent("334 BC", "Alexander begins conquest of Persia", "⚔️"),
            TimelineEvent("330 BC", "Writes major works on ethics and politics", "📚"),
            TimelineEvent("325 BC", "Completes biological research", "🔬"),
            TimelineEvent("323 BC", "Alexander dies; Aristotle flees Athens", "💔"),
            TimelineEvent("322 BC", "Dies in Chalcis at age 62", "⭐")
        )
        
        items(timeline) { event ->
            TimelineCard(event)
        }
    }
}

data class Work(
    val title: String,
    val year: String,
    val description: String,
    val icon: String,
    val id: String? = null
)

data class TimelineEvent(
    val year: String,
    val event: String,
    val icon: String
)

@Composable
fun InfoCard(title: String, icon: String, content: String) {
    GlassmorphicCard(
        modifier = Modifier.fillMaxWidth(),
        glowColor = PremiumColors.CyberBlue
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(icon, fontSize = 32.sp)
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                content,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White.copy(alpha = 0.9f),
                lineHeight = 24.sp
            )
        }
    }
}

@Composable
fun HighlightCard(
    title: String,
    subtitle: String,
    description: String,
    gradient: List<Color>
) {
    PremiumGlassCard(
        modifier = Modifier.fillMaxWidth(),
        gradientColors = gradient
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                title,
                style = MaterialTheme.typography.displayMedium,
                fontWeight = FontWeight.Black,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                subtitle,
                style = MaterialTheme.typography.titleMedium,
                color = Color.White.copy(alpha = 0.9f),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                description,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White.copy(alpha = 0.85f),
                textAlign = TextAlign.Center,
                lineHeight = 24.sp
            )
        }
    }
}

@Composable
fun WorkCard(work: Work, onClick: (() -> Unit)? = null) {
    val modifier = if (onClick != null && work.id != null) {
        Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    } else {
        Modifier.fillMaxWidth()
    }
    
    GlassmorphicCard(
        modifier = modifier,
        glowColor = if (work.id != null) PremiumColors.ElectricPurple else PremiumColors.ElectricPurple.copy(alpha = 0.5f)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(work.icon, fontSize = 32.sp)
                Spacer(modifier = Modifier.width(12.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        work.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        work.year,
                        style = MaterialTheme.typography.labelMedium,
                        color = PremiumColors.CyberBlue
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        work.description,
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.White.copy(alpha = 0.8f)
                    )
                }
            }
            
            if (work.id != null) {
                Icon(
                    imageVector = Icons.Default.ChevronRight,
                    contentDescription = "View details",
                    tint = PremiumColors.ElectricPurple,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
fun TimelineCard(event: TimelineEvent) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(androidx.compose.foundation.shape.CircleShape)
                    .background(PremiumColors.ElectricPurple),
                contentAlignment = Alignment.Center
            ) {
                Text(event.icon, fontSize = 20.sp)
            }
            if (event != TimelineEvent("322 BC", "Dies in Chalcis at age 62", "⭐")) {
                Box(
                    modifier = Modifier
                        .width(2.dp)
                        .height(60.dp)
                        .background(PremiumColors.ElectricPurple.copy(alpha = 0.3f))
                )
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        GlassmorphicCard(
            modifier = Modifier.weight(1f),
            glowColor = PremiumColors.CyberBlue
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    event.year,
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = PremiumColors.CyberBlue
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    event.event,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White
                )
            }
        }
    }
}
